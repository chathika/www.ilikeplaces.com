package ai.ilikeplaces.entities;

import ai.ilikeplaces.doc.BIDIRECTIONAL;
import ai.ilikeplaces.doc.License;
import ai.ilikeplaces.doc.WARNING;
import ai.ilikeplaces.util.EntityLifeCycleListener;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ravindranath Akila
 * Date: Jan 25, 2010
 * Time: 1:01:22 PM
 */

@License(content = "This code is licensed under GNU AFFERO GENERAL PUBLIC LICENSE Version 3")
@Entity
@EntityListeners({EntityLifeCycleListener.class})
public class Album {

    private Long albumId;

    private String albumName;

    private String albumDescription;

    private List<PrivatePhoto> albumPhotos;

    private List<HumansAlbum> albumOwners;
    final static public String albumOwnersCOL = "albumOwners";

    private List<HumansAlbum> albumVisitors;
    final static public String albumVisitorsCOL = "albumVisitors";

    private PrivateEvent albumPrivateEvent;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(final Long albumId) {
        this.albumId = albumId;
    }

    @Transient
    public Album setAlbumIdR(final Long albumId) {
        setAlbumId(albumId);
        return this;
    }

    @Column(length = 1023)
    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(final String albumDescription) {
        this.albumDescription = albumDescription;
    }

    @Transient
    public Album setAlbumDescriptionR(final String albumDescription) {
        this.albumDescription = albumDescription;
        return this;
    }

    @Column(length = 255)
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(final String albumName) {
        this.albumName = albumName;
    }

    @Transient
    public Album setAlbumNameR(final String albumName) {
        this.albumName = albumName;
        return this;
    }


    @BIDIRECTIONAL(ownerside = BIDIRECTIONAL.OWNING.NOT)
    @OneToOne(mappedBy = PrivateEvent.privateEventAlbumCOL, fetch = FetchType.EAGER)
    public PrivateEvent getAlbumPrivateEvent() {
        return albumPrivateEvent;
    }

    public void setAlbumPrivateEvent(PrivateEvent albumPrivateEvent) {
        this.albumPrivateEvent = albumPrivateEvent;
    }

    @BIDIRECTIONAL(ownerside = BIDIRECTIONAL.OWNING.IS)
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    public List<HumansAlbum> getAlbumOwners() {
        return albumOwners;
    }

    public void setAlbumOwners(final List<HumansAlbum> albumOwners) {
        this.albumOwners = albumOwners;
    }

    @WARNING(warning = "Not owner because when a photo is deleted, the albums will automatically reflect it." +
            "The other way round is not feasible because a user will own photos, not albums.")
    @BIDIRECTIONAL(ownerside = BIDIRECTIONAL.OWNING.NOT)
    @ManyToMany(mappedBy = PrivatePhoto.albumsCol, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    public List<PrivatePhoto> getAlbumPhotos() {
        return albumPhotos;
    }

    public void setAlbumPhotos(final List<PrivatePhoto> albumPhotos) {
        this.albumPhotos = albumPhotos;
    }


    @BIDIRECTIONAL(ownerside = BIDIRECTIONAL.OWNING.IS)
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    public List<HumansAlbum> getAlbumVisitors() {
        return albumVisitors;
    }

    public void setAlbumVisitors(final List<HumansAlbum> albumVisitors) {
        this.albumVisitors = albumVisitors;
    }
}