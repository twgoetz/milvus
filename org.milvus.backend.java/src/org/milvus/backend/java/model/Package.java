package org.milvus.backend.java.model;

public class Package {
  
  private final Package parent;
  
  private final String name;
  
  public Package() {
    super();
    this.parent = null;
    this.name = null;
  }
  
  public Package(Package parent, String name) {
    super();
    this.parent = parent;
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean isDefaultPackage() {
    return this.name == null;
  }
  
  public boolean hasParent() {
    return this.parent != null;
  }

}
