package lzb.com.net;

/**
 * Created by lzb92 on 2015/4/11.
 */
public class GetMainPageMsg {
    private final String url="";
    private final String charset="";

    public GetMainPageMsg(){
        BaseNet baseNet=new BaseNet(charset,HttpMethod.GET,new BaseNet.SuccessCallBack() {
            @Override
            public void success(String resultStr) {

            }
        },new BaseNet.FailCallBack() {
            @Override
            public void fail() {

            }
        },url);
    }

}
