package com.ishikawa.fwm.fwmcore.config;

import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitJoinColumnNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;


public class CustomImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

    @Override
    public Identifier determineJoinColumnName(ImplicitJoinColumnNameSource source) {
        final String name;

        if ( source.getNature() == ImplicitJoinColumnNameSource.Nature.ELEMENT_COLLECTION
                || source.getAttributePath() == null ) {
            name = transformEntityName(source.getEntityNaming());
        }
        else {
            name = transformAttributePath(source.getAttributePath());
        }

        return toIdentifier( name, source.getBuildingContext() );
    }
}
