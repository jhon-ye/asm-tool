package lsieun;import lsieun.cv.*;import lsieun.utils.FileUtils;import org.objectweb.asm.*;public class HelloWorldTransformCore {    public static void main(String[] args) {        String relativePath = "sample/HelloWorld.class";        String filePath = FileUtils.getFilePath(relativePath);        byte[] bytes = FileUtils.readBytes(filePath);        int parseOptions = ClassReader.SKIP_FRAMES | ClassReader.SKIP_DEBUG;        assert bytes != null;        ClassReader cr = new ClassReader(bytes);        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);        int api = Opcodes.ASM9;        ClassVisitor cv = new ClassChangeInterfaceVisitor(api, cw);        cv = new ClassChangeVersionVisitor(api, cw);        cv = new ClassRemoveFieldVisitor(api, cw, "strValue", "Ljava/lang/String;");        cv = new ClassAddFieldVisitor(api, cw, Opcodes.ACC_PUBLIC, "strValue", "Ljava/lang/String;");        cv = new ClassRemoveMethodVisitor(api, cw, "test", "()V");        cv = new ClassAddMethodVisitor(api, cw, Opcodes.ACC_PUBLIC, "mul", "(II)I", null, null) {            @Override            protected void generateMethodBody(MethodVisitor mv) {                mv.visitCode();                mv.visitVarInsn(Opcodes.ILOAD, 1);                mv.visitVarInsn(Opcodes.ILOAD, 2);                mv.visitInsn(Opcodes.IMUL);                mv.visitInsn(Opcodes.IRETURN);                mv.visitMaxs(2, 2);                mv.visitEnd();            }        };        cr.accept(cv, parseOptions);        byte[] bytes1 = cw.toByteArray();        FileUtils.writeBytes(filePath, bytes1);    }}