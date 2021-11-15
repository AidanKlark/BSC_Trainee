package parse.commandParse;

import parse.ParseLine;

import java.util.List;

public class ParseFactory {

    public static List<ParseLine> getCommands(){
        return List.of(new AddParse(),
                new DeleteParse(),
                new EditParse(),
                new PrintParse(),
                new SearchParse(),
                new ToggleParse());

}
