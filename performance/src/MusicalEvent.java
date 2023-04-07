import java.util.ArrayList;
import java.util.List;
public class MusicalEvent {
    public static void main(String[] args) {
        Performace performance01 = new Performace("Taylor Swift","Eras Tour",2023,"Glenadale");
        BackupSinger backupSinger01 = new BackupSinger("Jeslyn");
        BackupSinger backupSinger02 = new BackupSinger("Melanie");
        BackupDancer backupDancer01 = new BackupDancer("Stephanie");
        BackupDancer backupDancer02 = new BackupDancer("Jake");
        MusicTrack track01 = new MusicTrack("Lavender Haze",5);
        MusicTrack track02 = new MusicTrack("All Too Well",4);
        MusicTrack track03 = new MusicTrack("the lakes",3.5);
        MusicTrack track04 = new MusicTrack("The Man",6);
        MusicTrack track05 = new MusicTrack("Love Story",7.3);
        performance01.addBackupSinger(backupSinger01);
        performance01.addBackupSinger(backupSinger02);
        performance01.addBackupDancer(backupDancer01);
        performance01.addBackupDancer(backupDancer02);
        performance01.Initializing();
    }
}

//declaring a interface to call whenever needed by backup artists
//Polymorphism and abstraction are used here.
interface ibackup{
    void backup();
}

//declaring the class artist
class Artist{
    //encapsulation
    private String name;

    //constructor for the class Artist
    public Artist(String name){
        this.name = name;
    }

    //method to get name since the intance is private
    public String getName(){
        return name;
    }

}

//declaring Singer class using Artist class(Inheritance)
class Singer extends Artist {
    public Singer(String name) {
        super(name);
    }
    public void singing(){
        System.out.println(getName()+" has started singing");
    }
}

//Same as above. But here I used that above interface
class BackupSinger extends  Singer implements ibackup{
    public BackupSinger(String name) {
        super(name);
    }
    public void backup(){
        System.out.println(getName()+" is backup singing.");
    }
}

//same as above
class BackupDancer extends Artist implements ibackup{
    public BackupDancer(String name) {
        super(name);
    }
    public void backup(){
        System.out.println(getName()+" is backup dancing.");
    }
}



class Performace{
    private String mainArtist;
    private String performanceName;
    private final int year;
    private final String venue;
    private List<MusicTrack> tracklist; //List to keep track on musictracks
    private List<BackupSinger> backupSingerList; //same as above
    private List<BackupDancer> backupDancerList; //same as above

    //constructor for the class performance
    public Performace(String mainArtist,String performanceName,int year,String venue){
        this.mainArtist = mainArtist;
        this.performanceName = performanceName;
        this.year = year;
        this.venue = venue;
        this.tracklist = new ArrayList<>();
        this.backupDancerList = new ArrayList<>();
        this.backupSingerList = new ArrayList<>();
    }
    //a method to change performance name
    public void set_PerformanceName(String performanceName1){
        this.performanceName = performanceName1;
    }
    public String getMainArtist() {
        return mainArtist;
    }

    public String getPerformanceName() {
        return performanceName;
    }

    public void setPerformanceName(String performanceName) {
        this.performanceName = performanceName;
    }

    public int getYear() {
        return year;
    }

    public String getVenue() {
        return venue;
    }

    //method to add objects into the list
    public void addMusicTrack(String name, double duration) {
        tracklist.add(new MusicTrack(name, duration));
    }

    public void addBackupSinger(BackupSinger backupSinger) {
        backupSingerList.add(backupSinger);
    }

    public void addBackupDancer(BackupDancer backupDancer) {
        backupDancerList.add(backupDancer);
    }

    //method we  want to run
    public void Initializing(){
        System.out.println("Welcome to the Performance "+getPerformanceName()+" by "+getMainArtist());
        System.out.println(getMainArtist()+" is singing.");
        for (BackupSinger backupSinger : backupSingerList) {
            backupSinger.backup();
        }
        for (BackupDancer backupDancer : backupDancerList) {
            backupDancer.backup();
        }
    }
}

//declaring LivePerformance class using Performance(inheritance)
class LivePerformance extends Performace{
    public LivePerformance(String mainArtist, String performanceName, int year, String venue) {
        super(mainArtist, performanceName, year, venue);
    }
    public void interact_with_audience(){
        System.out.println("Hello Crowd");
    }
    public void live_record(){
        System.out.println("Recorded live");
    }

}
//same as above
class StudioPerformance extends Performace{

    public StudioPerformance(String mainArtist, String performanceName, int year, String venue) {
        super(mainArtist, performanceName, year, venue);
    }
    public void audio_processing(){
        System.out.println("Audio Processed");
    }
    public void studio_record(){
        System.out.println("Studio Record");
    }
}

//declaring the class MusicTrack
class MusicTrack{
    private String trackName;
    private double duration;

    public MusicTrack(String trackName,double duration){
        this.trackName = trackName;
        this.duration = duration;
    }

    public String getName(){
        return trackName;
    }
    public double getDuration(){
        return duration;
    }

}

