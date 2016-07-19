package learn.spring.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 7/19/2016.
 */
@Component
@ConfigurationProperties("amazon")
public class AmazonProperties {

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getAssociateId() {
        return associateId;
    }

    private String associateId;
}
