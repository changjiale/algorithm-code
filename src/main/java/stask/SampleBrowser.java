package stask;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author: changjiale
 * @create: 2019/12/08 16:27
 * @description: stack实现浏览器前进后退功能
 */
public class SampleBrowser {

    private String currentPage;

    private StackBaseOnLinkedList backStack;
    private StackBaseOnLinkedList forwardStack;

    public SampleBrowser() {
        this.backStack = new StackBaseOnLinkedList();
        this.forwardStack = new StackBaseOnLinkedList();
    }

    public void open(String url) {
        if (this.currentPage != null) {
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url, "Open");

    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

    public String goBack() {
        if (this.canGoBack()) {
            this.forwardStack.push(this.currentPage);
            String backUrl = (String)this.backStack.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }

        System.out.println("cannot go back, no pages behind");
        return "";
    }

    public String goForward() {
        if (this.canGoForward()) {
            this.backStack.push(this.currentPage);
            String forwardUrl = (String)this.forwardStack.pop();
            showUrl(forwardUrl, "Forward");
            return forwardUrl;
        }
        System.out.println("cannot go forward, no pages head");
        return null;
    }

    public boolean canGoBack() {
        return this.backStack.size() > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.size() > 0;
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }






    public static void main(String[] args) {

        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();

    }
}
