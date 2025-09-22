package com.civa.retotecnico.buses.bus_api.dto;



import java.util.List;
import java.util.Objects;

/**
 * DTO for paginated Bus responses following Spring's Page structure
 */

public class PageBusDto {


    private List<BusDto> content;


    private int number;


    private int size;

 
    private long totalElements;


    private int totalPages;


    private boolean first;


    private boolean last;


    private boolean empty;

    // Default constructor
    public PageBusDto() {}

    // Constructor with all fields
    public PageBusDto(List<BusDto> content, int number, int size, long totalElements, 
                      int totalPages, boolean first, boolean last, boolean empty) {
        this.content = content;
        this.number = number;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.first = first;
        this.last = last;
        this.empty = empty;
    }

    // Getters and Setters
    public List<BusDto> getContent() {
        return content;
    }

    public void setContent(List<BusDto> content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageBusDto that = (PageBusDto) o;
        return number == that.number && 
               size == that.size && 
               totalElements == that.totalElements && 
               totalPages == that.totalPages && 
               first == that.first && 
               last == that.last && 
               empty == that.empty && 
               Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, number, size, totalElements, totalPages, first, last, empty);
    }

    @Override
    public String toString() {
        return "PageBusDto{" +
                "content=" + content +
                ", number=" + number +
                ", size=" + size +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", first=" + first +
                ", last=" + last +
                ", empty=" + empty +
                '}';
    }
}