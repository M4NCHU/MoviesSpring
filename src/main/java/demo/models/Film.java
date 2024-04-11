package demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tytul;
    private String opis;
    private int rokWydania;
    private int dlugosc;
    private String plakatURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gatunek_id")
    private Gatunek gatunek;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_aktor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "aktor_id"))
    private Set<Aktor> aktorzy = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_rezyser",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "rezyser_id"))
    private Set<Rezyser> rezyserzy = new HashSet<>();

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ocena> opinie = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_filmowe_id")
    private StudioFilmowe studioFilmowe;

    private Double sredniaOcena;

    public Double getSredniaOcena() {
        return sredniaOcena;
    }

    public void setSredniaOcena(Double sredniaOcena) {
        this.sredniaOcena = sredniaOcena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public String getPlakatURL() {
        return plakatURL;
    }

    public void setPlakatURL(String plakatURL) {
        this.plakatURL = plakatURL;
    }

    public Gatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(Gatunek gatunek) {
        this.gatunek = gatunek;
    }

    public Set<Ocena> getOpinie() {
        return opinie;
    }

    public void setOpinie(Set<Ocena> opinie) {
        this.opinie = opinie;
    }

    public String getNazwaGatunku() {
        return gatunek != null ? gatunek.getNazwa() : "";
    }

    public Set<Aktor> getAktorzy() {
        return aktorzy;
    }

    public void setAktorzy(Set<Aktor> aktorzy) {
        this.aktorzy = aktorzy;
    }

    public Set<Rezyser> getRezyserzy() {
        return rezyserzy;
    }

    public void setRezyserzy(Set<Rezyser> rezyserzy) {
        this.rezyserzy = rezyserzy;
    }

    public StudioFilmowe getStudioFilmowe() {
        return studioFilmowe;
    }

    public void setStudioFilmowe(StudioFilmowe studioFilmowe) {
        this.studioFilmowe = studioFilmowe;
    }

    public String getRezyserzyNazwy() {
        return rezyserzy.stream()
                .map(rezyser -> rezyser.getImie() + " " + rezyser.getNazwisko())
                .collect(Collectors.joining(", "));
    }

    public String getAktorzyNazwy() {
        return aktorzy.stream()
                .map(aktor -> aktor.getImie() + " " + aktor.getNazwisko())
                .collect(Collectors.joining(", "));
    }

    public String getNazwaStudiaFilmowego() {
        return studioFilmowe != null ? studioFilmowe.getNazwa() : "Brak informacji";
    }


}
