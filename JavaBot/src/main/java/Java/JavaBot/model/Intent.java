package Java.JavaBot.model;

import java.util.List;

public class Intent {
    private String tag;
    private List<String> patterns;
    private List<String> response;


    public Intent() {

    }

    public Intent(String tag, List<String> patterns, List<String> response) {
        this.tag = tag;
        this.patterns = patterns;
        this.response = response;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }


}
