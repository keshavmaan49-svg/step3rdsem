public class week7q2 {

    static class Playlist {
        private String[] songs;
        private int songCount;

        public Playlist(int maxSize) {
            songs = new String[maxSize];
            songCount = 0;
        }

        public void addSong(String song) {
            if (songCount < songs.length) {
                songs[songCount] = song;
                songCount++;
            }
        }

        public String[] getSongs() {
            String[] copy = new String[songCount];

            System.arraycopy(songs, 0, copy, 0, songCount);

            return copy;
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Original playlist:");
        for (String song : copy) {
            System.out.println(song);
        }

        copy[0] = "Hacked";

        System.out.println("\nAfter modifying the copy:");

        String[] songs = p.getSongs();

        for (String song : songs) {
            System.out.println(song);
        }

        System.out.println("\nSong count: " + p.getSongCount());
    }
}