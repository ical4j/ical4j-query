package org.ical4j.query;

import org.ical4j.query.command.JettyRunCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "query", description = "iCal4j query service",
        subcommands = {JettyRunCommand.class})
public class ICalendarQueryMain implements Runnable {

    @Override
    public void run() {
        System.out.println("iCal4j Query. Usage: query <subcommand> [options]");
    }

    public static void main(String[] args) {
        new CommandLine(new ICalendarQueryMain()).execute(args);
    }
}
