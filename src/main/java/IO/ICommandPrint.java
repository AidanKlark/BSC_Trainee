package IO;

import storage.TaskStatus;

public interface ICommandPrint {

    void out(Integer key, TaskStatus taskStatus);
}
