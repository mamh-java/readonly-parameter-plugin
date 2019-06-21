package com.wangyin.ams.cms.abs.ParaReadOnly;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.model.StringParameterValue;


public class WReadonlyTextParameterValue extends StringParameterValue {

    private static final long serialVersionUID = 6926027508686211675L;

    @DataBoundConstructor
    public WReadonlyTextParameterValue(String name, String value) {
        super(name, value);
    }

    public WReadonlyTextParameterValue(String name, String value, String description) {
        super(name, value, description);
    }

    @Override
    public String toString() {
        return "(WReadonlyTextParameterValue) " + getName() + "='" + value + "'";
    }
}