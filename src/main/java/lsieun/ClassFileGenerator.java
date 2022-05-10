package lsieun;import lsieun.utils.FileUtils;import org.objectweb.asm.ClassWriter;import org.objectweb.asm.FieldVisitor;import org.objectweb.asm.MethodVisitor;import org.objectweb.asm.Opcodes;/***  生成*** */public class ClassFileGenerator {    public static void main(String[] args) {        String relativePath = "sample/HelloWorld.class";        String filePath = FileUtils.getFilePath(relativePath);        //byte[] bytes = dump();        byte[] bytes = dump5();        FileUtils.writeBytes(filePath, bytes);    }    /**     * 生成接口     *  public interface HelloWorld {}     * @return     */    public static byte[] dump() {        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);        cw.visit(Opcodes.V1_8,                Opcodes.ACC_PUBLIC | Opcodes.ACC_ABSTRACT | Opcodes.ACC_INTERFACE,                "sample/HelloWorld",                null,                "java/lang/Object",                null);        cw.visitEnd();        return cw.toByteArray();    }    /**     * 生成接口 + 字段 + 方法     * public interface HelloWorld extends Cloneable {     *     int LESS = 0;     *     int compareTo(Object o);     * }     */    public static byte[] dump2() {        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);        cw.visit(Opcodes.V1_8,                Opcodes.ACC_PUBLIC | Opcodes.ACC_ABSTRACT | Opcodes.ACC_INTERFACE,                "sample/HelloWorld",                null,                "java/lang/Object",                new String[] {"java/lang/Cloneable"});        FieldVisitor fv = cw.visitField(Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL | Opcodes.ACC_STATIC,                "LESS",                "I",                null,                -1);        fv.visitEnd();        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_ABSTRACT,                "compareTo",                "(Ljava/lang/Object;)I",                null,                null);        mv.visitEnd();        cw.visitEnd();        return cw.toByteArray();    }    /**     * 生成类     * public class HelloWorld {     *  static {     *      System.out.printf("static code block")     *  }     * }     */    public static byte[] dump3() {        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);        cw.visit(Opcodes.V1_8,                Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER,                "sample/HelloWorld",                null,                "java/lang/Object",                null);        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC,                "<init>",                "()V",                null,                null);        mv.visitCode();        mv.visitEnd();        MethodVisitor mv2 = cw.visitMethod(Opcodes.ACC_STATIC,                "<cinit>",                "()V",                null,                null);        mv2.visitCode();        mv2.visitEnd();        cw.visitEnd();        return cw.toByteArray();    }    /**     * public interface HelloWorld {     *   @MyTag(name="tomcat", age = 10)     *   int intValue = 10;     *     * }     *     * public @interface MyTag {     *     String name();     *     int age();     * }     *     *     * @return     */    public static byte[] dump4() {        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);        cw.visit(Opcodes.V1_8,                Opcodes.ACC_PUBLIC | Opcodes.ACC_ABSTRACT | Opcodes.ACC_INTERFACE,                "sample/HelloWorld",                null,                "java/lang/Object",                null);        FieldVisitor fv = cw.visitField(Opcodes.ACC_PRIVATE ,                "LESS",                "I",                null,                -1);        fv.visitEnd();        cw.visitEnd();        return cw.toByteArray();    }    /**     * methodVisitor 示例     */    public static byte[] dump5() {        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);        cw.visit(Opcodes.V1_8,                Opcodes.ACC_PUBLIC | Opcodes.ACC_SUPER,                "sample/HelloWorld",                null,                "java/lang/Object",                null);        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC,                "<init>",                "()V",                null,                null);        mv.visitCode();        mv.visitVarInsn(Opcodes.ALOAD, 0);        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object","<init>", "()V", false);        mv.visitInsn(Opcodes.RETURN);        mv.visitMaxs(1, 1);        mv.visitEnd();        mv.visitEnd();        cw.visitEnd();        return cw.toByteArray();    }}