package org.ical4j.query;

import org.ical4j.query.command.CalendarCollectionCommand;
import org.ical4j.query.command.JettyRunCommand;
import org.ical4j.query.command.VersionProvider;
import picocli.CommandLine;

@CommandLine.Command(name = "query", description = "iCal4j query service",
        subcommands = {CalendarCollectionCommand.class, JettyRunCommand.class},
        mixinStandardHelpOptions = true, versionProvider = VersionProvider.class)
public class ICalendarQueryMain {

    public static void main(String[] args) {
        new CommandLine(new ICalendarQueryMain()).execute(args);
    }
}
