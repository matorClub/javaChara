package club.mator.common;

/**
 * Created: 下午12:01-2018/7/25
 * author: feiFei.chen
 * desc: TODO Something
 * version: 1.0
 */
public interface Method {

    <S> S getT(S s);

    <S> String getStr(S s);

    <S> void getC(S s);

}
