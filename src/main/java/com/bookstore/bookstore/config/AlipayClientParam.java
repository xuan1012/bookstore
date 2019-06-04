package com.bookstore.bookstore.config;

/**
 * @program: bookstore
 * @author: xuan
 * @create: 2019-06-04 13:49
 **/
public class AlipayClientParam {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092900620658";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCDKVHr5GhwzF9LB6wSuchpI8Ri2B/ssSo0ygm4nm8LkTdNUiLmrRtiMY7/k2GbfF9F6RrKzqLaCzm6w7NvJvwi+CjT67fr9wOr56pJ/f1YWjuxeM+sYr+G6ustsom2a75JGIr7CV9avA9qXcM/7hUtD0XQeSvEV6U4MAxovWs69XtJnPKkZhLH+EVhdBWEragZ2bGm2m7L+K4f85PjwWmQZI1qE1lOZiiUbXdAi5rV5ECufMno/4fQRS34fk0oncjncATU1uHqLjDfLrRS71nSlGbSUIuuhohFv3gjbkklcoi9IvO2kqydUEvtJCuGqswGKspZ1eggJcG+WN8HKf/tAgMBAAECggEAJR3iUvD2JUWQifkH1tzAPBClGJu0nRSdrwalrZsYLZvQnI7r1X+TSjxgDS815fxSMcR/knjbWPzoP1P2STQtEfBMDXydNadXYKRUak/4C7KtRdG8YzomnRWJrArkMb1XwfOyEMxcMZ8ada1G/aZwU6oIxbAklJGA7d+bA2DnIW3CrlDDe58kKvhg4PG7Pusb3PxsS7q/KwrafmAayKx+T0qDQQg7iG3y5OlfoDSXdpIw26ZT1PfMy7YqCyLxm2yaq9oaee2gpofwaepnYjDNvsN8ooMuDHq99NzcOxWl8ZyR3WHx4dowOSPC3iKyC2NTpcaeEeSbbJKqovNg7gbdOQKBgQDCDGE6UURxCTxd2Rzf/X1v6nDx+6YlnbUFvyDsz55l3Xzv8r03k+AOcP3Wk8sogW1Slj3r79OdvaMdjLkDIRTQq1XB+YpHlSbAR1PVngA4o7a+C+gc9mCYtiJvNXCa4hYja2BwBpjxY5/9lU3WrtzkUUnJUBeRht+2EMypU5sGRwKBgQCtCSyRCNwexpgu2dQEkmRUrKF2pWRyny0/SfS7OJaJStCcZVDvD4FkAMIG9vTZbRhF/2kV3BQs8ZoPvY6BrhzqF/tdRrBsAV8iYmyP2lbLfy9wih3iwaJTuYmHeyW5bTTCYiInwkAZwtc0SJOaTRZxLKJy2tRu7ozsfLz+OC9+KwKBgQCoR5ghvMw/wqSpNlmGHgyj+4nLMFLbmDKeMyvYcgyJhlSMudNB2Wma3H4lkbHDBMrLriMw8qBv0T8dpyXjAtNMSulp+H/kqAIdCT44qHbEp6UYlrbKNxd6F6kxDAUFLD/Ko5nUTMRhweXDQbFpFefV0HDOtjhaKb7j4xm5VhnAjQKBgFzQ+PjrObfAa01mRtYU+IB7ATk1SoY5X/n836u1lPocCX560kkJlixgQ7OcsIYYgNa7RFEXdjMNfchHs7NYA+aF6q2EB4pHyhIVnYokYj5SAM5rJ9DEcSBb+6uSoQ+vxocmQI/3II8w9mLzM0mnZAxdFt5pB15h03HfDzmGReN1AoGAN9KE4kZ98dcG55nHB4fNsxP/TMczJGEs7UG9Wk15K4O3KXu/RsP8cO1IIG/t0b3P7bibsAUMSIaUGH3nQ9Lg8LE7gver+C9P0v2JSctj+eaWxoYh9Vplx00vWdUEV68nnioHpExC8FJETzgT2V6EGvC+pFA/TUaVyq5jIgPcCqg=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgylR6+RocMxfSwesErnIaSPEYtgf7LEqNMoJuJ5vC5E3TVIi5q0bYjGO/5Nhm3xfRekays6i2gs5usOzbyb8Ivgo0+u36/cDq+eqSf39WFo7sXjPrGK/hurrLbKJtmu+SRiK+wlfWrwPal3DP+4VLQ9F0HkrxFelODAMaL1rOvV7SZzypGYSx/hFYXQVhK2oGdmxptpuy/iuH/OT48FpkGSNahNZTmYolG13QIua1eRArnzJ6P+H0EUt+H5NKJ3I53AE1Nbh6i4w3y60Uu9Z0pRm0lCLroaIRb94I25JJXKIvSLztpKsnVBL7SQrhqrMBirKWdXoICXBvljfByn/7QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/alipay/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/alipay/alipayReturnNotice";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
