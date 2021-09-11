package cn.melon.study.ioc;

import java.io.IOException;
import java.util.List;

/**
 * cn.melon.study.ioc.PackageScanner
 *
 * @author imelonkid
 * @date 2021/09/09 18:43
 **/
public interface PackageScanner {

    List<String> getFullyQualifiedClassNameList() throws IOException;
}
