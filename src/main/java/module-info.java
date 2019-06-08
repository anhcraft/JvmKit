module dev.anhcraft.jvmkit {
    requires kotlin.stdlib;
    requires java.sql;
    requires org.jetbrains.annotations;

    exports dev.anhcraft.jvmkit.builders;
    exports dev.anhcraft.jvmkit.helpers;
    exports dev.anhcraft.jvmkit.lang;
    exports dev.anhcraft.jvmkit.lang.annotation;
    exports dev.anhcraft.jvmkit.lang.enumeration;
    exports dev.anhcraft.jvmkit.trackers;
    exports dev.anhcraft.jvmkit.trackers.reports;
    exports dev.anhcraft.jvmkit.utils;
}
