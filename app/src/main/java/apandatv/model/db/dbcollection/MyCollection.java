package apandatv.model.db.dbcollection;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "MY_COLLECTION".
 */
public class MyCollection {

    private Long id;
    private String imagpath;
    private String name;
    private String data;
    private String moviepath;

    public MyCollection() {
    }

    public MyCollection(Long id) {
        this.id = id;
    }

    public MyCollection(Long id, String imagpath, String name, String data, String moviepath) {
        this.id = id;
        this.imagpath = imagpath;
        this.name = name;
        this.data = data;
        this.moviepath = moviepath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagpath() {
        return imagpath;
    }

    public void setImagpath(String imagpath) {
        this.imagpath = imagpath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMoviepath() {
        return moviepath;
    }

    public void setMoviepath(String moviepath) {
        this.moviepath = moviepath;
    }

}