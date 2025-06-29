package codepointtool.model;

import java.util.List;

import lombok.Builder;
import lombok.Value;

/**
 * CodePointsクラスのモデル
 */
@Value
@Builder
public class CodePointsClassModel {
    private final String packageName; // パッケージ名
    private final String className; // クラス名
    private final String description; // クラスの説明
    private final List<JISCharacter> characters; // JISコードの文字リスト

}
