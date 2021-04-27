package sg.edu.rp.c346.s19047241.p03_classjournalteam;

import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable {

    private String moduleCode, moduleName;
    private ArrayList<DailyCA> dailyCAArrayList;

    public Module(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public ArrayList<DailyCA> getDailyCAArrayList() {
        return dailyCAArrayList;
    }

    public void setDailyCAArrayList(ArrayList<DailyCA> dailyCAArrayList) {
        this.dailyCAArrayList = dailyCAArrayList;
    }
}
