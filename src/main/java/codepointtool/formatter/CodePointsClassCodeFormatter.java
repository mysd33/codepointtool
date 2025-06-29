package codepointtool.formatter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import codepointtool.model.CodePointsClassModel;
import lombok.extern.slf4j.Slf4j;

/**
 * CodePointsClassModelを元にJavaのコードを生成するクラス
 * 
 * このクラスは、Velocityテンプレートエンジンを使用して、 CodePointsClassModelの内容に基づいてJavaコードを生成します。
 */
@Slf4j
public class CodePointsClassCodeFormatter {
    private static final String GENERATED_SOURCE_DIR = "generated/src/main/java/";
    private static final String VM_TEMPLATE_FILEPATH = "template/CodePointsClass.vm";

    /**
     * CodePointsClassModelをもとにTERASOLUNA Server FrameworkのCodePointsクラスを作成します。
     * @param model CodePointsClassModel
     * @throws IOException
     */
    public void format(CodePointsClassModel model) throws IOException {
        log.info("{}に{}.{}のソースコード作成", GENERATED_SOURCE_DIR, model.getPackageName(), model.getClassName());
        // Velocityの初期化
        Velocity.init();
        VelocityContext context = new VelocityContext();
        // Velocityのコンテキストにモデルを設定
        context.put("codePointsClass", model);

        String filePath = new StringBuilder(GENERATED_SOURCE_DIR).//
                append(model.getPackageName().replace('.', '/'))//
                .append("/").append(model.getClassName())
                .append(".java").toString();

        File file = new File(filePath);
        // ディレクトリを作成
        file.getParentFile().mkdirs();

        // Velocityテンプレートを使用してファイルに書き込む
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            Template template = Velocity.getTemplate(VM_TEMPLATE_FILEPATH);
            template.merge(context, writer);
        }
    }
}
