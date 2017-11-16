package by.emptythoughts.colonizer.economics;

import by.emptythoughts.colonizer.economics.resource.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Resources {
    private List<Resource> resourceList;

    private Resources() {
        resourceList = new ArrayList<Resource>();
    }

    public Resources(String filePath) {
        this.resourceList = new ArrayList<Resource>(getResourceNames(filePath));
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public List<Resource> getResourceNames(String filePath) {
        try {
            List<Resource> list = new ArrayList<Resource>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
            while (list.add(new Resource(bufferedReader.readLine()))) {

            }
            return list;
        } catch (IOException exception) {
            System.out.println(exception.toString());
        }
        return null;
    }
}
