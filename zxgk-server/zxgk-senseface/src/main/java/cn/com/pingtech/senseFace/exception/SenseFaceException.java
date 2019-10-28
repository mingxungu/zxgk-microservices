package cn.com.pingtech.senseFace.exception;

/**
 * @Auther: psf
 * @Date: 2019/8/30 10:48
 * @Description: 商汤人脸自定义业务异常
 */
public class SenseFaceException extends RuntimeException {
    private String message;

    public SenseFaceException() {
    }

    public SenseFaceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
