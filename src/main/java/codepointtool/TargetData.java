package codepointtool;

import codepointtool.parser.TargetFilter;
import lombok.Builder;
import lombok.Value;

/**
 * 自動生成対象のコードポイントクラスの情報を保持するクラス。
 */
@Value
@Builder
public class TargetData {
    // 生成するクラス名
    private final String className;
    // 生成するクラスの説明（javadocコメントに使用）
    private final String description;
    // JIS縮退マップのExcelファイルの値から文字を抽出する条件（面、区やJIS区分等）
    private final TargetFilter targetFilter;
}
