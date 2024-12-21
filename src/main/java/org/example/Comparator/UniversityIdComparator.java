package org.example.Comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.University;

public class UniversityIdComparator implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getId(), u2.getId());
    }
}
