package blockshifter.view;

import blockshifter.model.Block;

public interface BlockDisplay extends Block.Observer{
    void display(Block block);
    Block block();
}
