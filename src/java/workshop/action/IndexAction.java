package workshop.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String execute() {
        return "SUCCESS";
    }
}