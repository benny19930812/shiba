
package project2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonOJ {
	private String title;
	private String UID;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}

	public String toString() {
        return "User [title=" + title + ", UID=" + UID + "]";
    }

	
}
