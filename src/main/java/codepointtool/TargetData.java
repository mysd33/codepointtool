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
    private final String className;
    private final String description;
    private final TargetFilter targetFilter;
}
