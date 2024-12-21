package org.example.Comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.University;

public class UniversityShortNameComparator implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getShortName(), u2.getShortName());
    }
}
