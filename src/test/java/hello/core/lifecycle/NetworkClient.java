package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출 ,url = "+url);

        // move to afterPropertiesSet
        //connect();
        //call("초기화 연결 메시지");
    }

    public void setUrl(String url) {

        this.url = url;
    }

    //서비스 시작시 호출 메서드
    public void connect() {

        System.out.println("connect: "+url);
    }

    public void call(String message) {

        System.out.println("call: " + url + " message ");
    }

    // 서비스 종료시 호출
    public void disconnect() {

        System.out.println("close: "+ url);
    }

    // 빈생성후 초기화
    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }

    //컨테이너가 내려가고 빈 이 죽을때 함수호출
    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
