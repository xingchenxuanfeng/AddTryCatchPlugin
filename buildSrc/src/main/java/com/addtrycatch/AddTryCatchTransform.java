package com.addtrycatch;

import com.android.build.api.transform.TransformException;
import com.android.build.api.transform.TransformInvocation;
import com.quinn.hunter.transform.HunterTransform;
import com.quinn.hunter.transform.RunVariant;

import org.gradle.api.Project;

import java.io.IOException;

/**
 * @author xc
 * @time 19-2-28.
 */
class AddTryCatchTransform extends HunterTransform {

    public AddTryCatchTransform(Project project) {
        super(project);
        this.bytecodeWeaver = new AddTryCatchWeaver();
    }

    @Override
    public void transform(TransformInvocation transformInvocation)
            throws TransformException, InterruptedException, IOException {
        super.transform(transformInvocation);
    }

    @Override
    protected RunVariant getRunVariant() {
        return super.getRunVariant();
    }
}
