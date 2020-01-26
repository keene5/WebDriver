import java.util.Objects;

public class ScopingConfiguration {

    private String programName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScopingConfiguration that = (ScopingConfiguration) o;
        return Objects.equals(programName, that.programName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programName);
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
