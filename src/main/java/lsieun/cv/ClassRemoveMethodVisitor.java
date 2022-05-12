package lsieun.cv;import org.objectweb.asm.ClassVisitor;import org.objectweb.asm.MethodVisitor;public class ClassRemoveMethodVisitor extends ClassVisitor {    private final String methodName;    private final String methodDesc;    public ClassRemoveMethodVisitor(int api, ClassVisitor classVisitor, String methodName, String methodDesc) {        super(api, classVisitor);        this.methodName = methodName;        this.methodDesc = methodDesc;    }    @Override    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {        if (name.equals(methodName) && descriptor.equals(methodDesc)) {            return null;        }        return super.visitMethod(access, name, descriptor, signature, exceptions);    }}