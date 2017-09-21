package net.kikkirej.protocolagent.options.output;

import java.io.File;
import java.io.IOException;

import net.kikkirej.protocolagent.options.Value;

public interface IOutput {

	File writeValue(Value[] values) throws IOException;

}