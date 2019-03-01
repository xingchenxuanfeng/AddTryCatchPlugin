package com.addtrycatch;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @author xc
 * @time 19-2-28.
 */
public class AddTryCatchAdviceAdapter extends AdviceAdapter {

    Label l1;
    Label l2;
    private String exceptionHandleClass;
    private String exceptionHandleMethod;

    protected AddTryCatchAdviceAdapter(int api, MethodVisitor mv, int access, String name, String desc) {
        super(api, mv, access, name, desc);
        Map<String, String> exceptionHandler = Config.getInstance().extension.exceptionHandler;
        if (exceptionHandler != null && !exceptionHandler.isEmpty()) {
            exceptionHandler.entrySet().forEach(entry -> {
                exceptionHandleClass = entry.getKey().replace(".", "/");
                exceptionHandleMethod = entry.getValue();
            });
        }
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        Label l0 = new Label();
        l1 = new Label();
        l2 = new Label();
        mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
        mv.visitLabel(l0);
    }

    @Override
    protected void onMethodExit(int i) {
        super.onMethodExit(i);
        mv.visitLabel(l1);
        Label l3 = new Label();
        mv.visitJumpInsn(GOTO, l3);
        mv.visitLabel(l2);
        mv.visitVarInsn(ASTORE, 1);
        if (exceptionHandleClass != null && exceptionHandleMethod != null) {
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESTATIC, exceptionHandleClass,
                    exceptionHandleMethod, "(Ljava/lang/Throwable;)V", false);
        }
        mv.visitLabel(l3);
    }
}
