package org.ical4j.query.command;

import picocli.CommandLine;

import java.net.URL;

public abstract class AbstractCollectionCommand implements Runnable {

    @CommandLine.Option(names = {"-X", "--query"})
    protected String query;

    @CommandLine.ArgGroup(multiplicity = "1")
    protected Input input;

    static class Input {
        @CommandLine.Option(names = {"-U", "--url"}, required = true)
        protected URL url;

        @CommandLine.Option(names = {"-F", "--file"}, required = true)
        protected String filename;

        @CommandLine.Option(names = {"--stdin"}, required = true)
        protected boolean stdin;
    }

}
