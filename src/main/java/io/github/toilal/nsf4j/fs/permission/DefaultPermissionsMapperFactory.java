package io.github.toilal.nsf4j.fs.permission;

import io.github.toilal.nsf4j.config.PermissionsConfig;

public class DefaultPermissionsMapperFactory implements PermissionsMapperFactory {
    @Override
    public PermissionsMapper newPermissionsMapper(PermissionsConfig permissions) {
        switch (permissions.getType()) {
            case SIMPLE:
                if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
                    return new SimpleWindowsPermissionsMapper(permissions);
                } else {
                    return new SimpleLinuxPermissionsMapper(permissions);
                }
            case LINUX:
                return new LinuxPermissionsMapper();
        }
        throw new IllegalStateException();
    }
}
