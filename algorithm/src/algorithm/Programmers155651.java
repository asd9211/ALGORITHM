import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[][] book_time) {
        List<Book> bookList = Arrays.stream(book_time)
                .map(time -> new Book(time[0], time[1]))
                .sorted(Comparator.comparing(Book::getStartTime))
                .collect(Collectors.toList());

        List<Room> roomList = new ArrayList<>();
        int roomNo = 1;

        roomList.add(new Room(roomNo));

        for (Book book : bookList) {
            boolean booked = false;

            Room room = roomList.stream()
                    .min(Comparator.comparing(r -> r.getBook().getEndTime()))
                    .get();

            if (room.enableBook(book)) {
                room.addBook(book);
                booked = true;
            }

            if (!booked) {
                roomNo++;
                Room newRoom = new Room(roomNo);
                newRoom.addBook(book);
                roomList.add(newRoom);
            }
        }

        return roomNo;
    }
}

class Room {
    private int roomNo;
    private Book book;

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public void addBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return this.book;
    }

    public boolean enableBook(Book newBook) {
        if (book == null || isLater(newBook.getStartTime(), book.getAbleBookTime())) {
            return true;
        }

        return false;
    }

    public boolean isLater(LocalTime time, LocalTime eTime) {
        return time.compareTo(eTime) >= 0;
    }
}

class Book {
    private static final int CLEAN_TIME = 10;

    private LocalTime startTime;
    private LocalTime endTime;

    public Book(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(startTime, formatter);
        this.endTime = LocalTime.parse(endTime, formatter);
    }

    public LocalTime getAbleBookTime() {
        return this.endTime.plusMinutes(CLEAN_TIME);
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

}
