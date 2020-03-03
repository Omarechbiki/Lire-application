
package es.upm.estiinf.assignment;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "link",
    "Author",
    "video"
})
public class LireMetadata {

    @JsonProperty("link")
    private String link;
    @JsonProperty("Author")
    private String author;
    @JsonProperty("video")
    private String video;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LireMetadata() {
    }

    /**
     * 
     * @param author
     * @param link
     * @param video
     */
    public LireMetadata(String link, String author, String video) {
        super();
        this.link = link;
        this.author = author;
        this.video = video;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    public LireMetadata withLink(String link) {
        this.link = link;
        return this;
    }

    @JsonProperty("Author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("Author")
    public void setAuthor(String author) {
        this.author = author;
    }

    public LireMetadata withAuthor(String author) {
        this.author = author;
        return this;
    }

    @JsonProperty("video")
    public String getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(String video) {
        this.video = video;
    }

    public LireMetadata withVideo(String video) {
        this.video = video;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public LireMetadata withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("link", link).append("author", author).append("video", video).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(link).append(video).append(additionalProperties).append(author).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LireMetadata) == false) {
            return false;
        }
        LireMetadata rhs = ((LireMetadata) other);
        return new EqualsBuilder().append(link, rhs.link).append(video, rhs.video).append(additionalProperties, rhs.additionalProperties).append(author, rhs.author).isEquals();
    }

}
