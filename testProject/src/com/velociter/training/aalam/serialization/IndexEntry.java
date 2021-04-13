
// Each object stores a second name and the position in the file where
// the corresponding record can be found. i.e. the first record
// is at position 0, the second at position 1, the third at position 2, etc.
package com.velociter.training.aalam.serialization;
import java.io.Serializable;

public class IndexEntry implements Serializable {
  // Constructor
	 private String name;
	  private int index;
  @Override
	public String toString() {
		return "IndexEntry [ index=" + index + " --->   " + name + "]";
	}

public IndexEntry(String name, int index) {
    this.name = name;
    this.index = index;
  }
  
  public String getName() {
    return name;
  }
  
  public int getPosition() {
    return index;
  }
  
  // Method to compare two IndexEntry objects
  public int compareTo(IndexEntry entry) {
    return name.compareTo(entry.name);
  }

 
}