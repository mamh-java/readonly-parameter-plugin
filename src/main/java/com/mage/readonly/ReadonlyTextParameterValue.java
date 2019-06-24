package com.mage.readonly;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.model.StringParameterValue;


public class ReadonlyTextParameterValue extends StringParameterValue {

    private static final long serialVersionUID = 6926027508686211675L;

    @DataBoundConstructor
    public ReadonlyTextParameterValue(String name, String value) {
        super(name, value);
    }

    public ReadonlyTextParameterValue(String name, String value, String description) {
        super(name, value, description);
    }

    @Override
    public String toString() {
        return "(ReadonlyTextParameterValue) " + getName() + "='" + value + "'";
    }
}