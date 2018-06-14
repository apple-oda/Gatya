package tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * ファイルを読み込みます
 *
 * @author アップル及川
 *
 */
public final class FileReader {
  // ファイルパス
  private String path;

  // 成功したかどうか
  private boolean succeeded;

  // 読み込んだリソース
  private List<String> resource;

  /**
   * ファイルを読み込みます
   *
   * @param path ファイルパス
   */
  public FileReader(String path) {
    this.path = path;
    resource = new ArrayList<>();
    try (BufferedReader reader = Files
        .newBufferedReader(Paths.get(path), StandardCharsets.UTF_8)) {
      String s;
      while ((s = reader.readLine()) != null) {
        resource.add(s);
      }
      succeeded = true;
    } catch (IOException e) {
      resource.clear();
      succeeded = false;
    }
  }

  /**
   * ファイルパスを取得します
   *
   * @return ファイルパス
   */
  public String getPath() {
    return path;
  }

  /**
   * 成功したかどうか取得します
   *
   * @return 成功したかどうか
   */
  public boolean isSucceeded() {
    return succeeded;
  }

  /**
   * 読み込んだリソースを取得します
   *
   * @return リソース
   */
  public List<String> getResource() {
    return resource;
  }
}
