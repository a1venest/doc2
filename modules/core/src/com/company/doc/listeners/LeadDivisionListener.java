package com.company.doc.listeners;

import com.company.doc.entity.Subdivisions;

public interface LeadDivisionListener {
    default boolean equals(Subdivisions leadDivision){
        if(this == leadDivision) return  true;
        if (leadDivision == null || getClass() != leadDivision.getClass()) return false;

        Subdivisions subdivisions = (Subdivisions) leadDivision;
        return leadDivision.equals(subdivisions.getLeadDivision());
    };
}
