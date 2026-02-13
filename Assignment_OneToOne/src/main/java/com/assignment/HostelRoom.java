package com.assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HostelRoom {
	@Id
	private int id;
    private int roomNumber;
    private String blockName;
    private int floorNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	@Override
	public String toString() {
		return "HostelRoom [id=" + id + ", roomNumber=" + roomNumber + ", blockName=" + blockName + ", floorNumber="
				+ floorNumber + "]";
	}
}
