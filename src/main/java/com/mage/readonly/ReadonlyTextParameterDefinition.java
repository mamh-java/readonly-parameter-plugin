package com.mage.readonly;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.model.ParameterDefinition;
import hudson.model.ParameterValue;


public class ReadonlyTextParameterDefinition extends ParameterDefinition {

    private static final long serialVersionUID = 8296806777255584941L;
    private String defaultValue;

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @DataBoundConstructor
    public ReadonlyTextParameterDefinition(String name, String defaultValue, String description) {
        super(name, description);
        this.defaultValue = defaultValue;
    }

    @Extension
    public static class DescriptorImpl extends ParameterDescriptor {
        @Override
        public String getDisplayName() {
            return "Readonly Text Parameter";
        }
    }

    @Override
    public ReadonlyTextParameterValue getDefaultParameterValue() {
        return new ReadonlyTextParameterValue(getName(), getDefaultValue(), getDescription());
    }


    public ParameterValue createValue(StaplerRequest req) {
        String[] value = req.getParameterValues(getName());
        if (value == null) {
            return getDefaultParameterValue();
        } else if (value.length != 1) {
            throw new IllegalArgumentException("Illegal number of parameter values for " + getName() + ": " + value.length);
        } else {
            return new ReadonlyTextParameterValue(getName(), value[0], getDescription());
        }
    }


    public ParameterValue createValue(StaplerRequest req, JSONObject jo) {
        ReadonlyTextParameterValue value = req.bindJSON(ReadonlyTextParameterValue.class, jo);
        value.setDescription(getDescription());
        return value;
    }
    
}
