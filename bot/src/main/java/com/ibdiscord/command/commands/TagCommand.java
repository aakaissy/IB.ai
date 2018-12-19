/**
 * Copyright 2018 raynichc
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author raynichc
 * @since 2018.11.29
 */

package com.ibdiscord.command.commands;

import com.ibdiscord.command.Command;
import com.ibdiscord.command.CommandContext;
import com.ibdiscord.command.permissions.CommandPermission;
import com.ibdiscord.main.IBai;
import net.dv8tion.jda.core.Permission;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TagCommand extends Command {

    public TagCommand() {
        super("tag",
                new HashSet<String>(),
                CommandPermission.discord(Permission.MANAGE_CHANNEL),
                Stream.of(new TagListCommand(), new TagCreateCommand(), new TagDeleteCommand()).collect(Collectors.toSet()));
    }

    @Override
    protected void execute(CommandContext context) {
        String botPrefix = IBai.getConfig().getStaticPrefix();
        context.reply("Correct usage: `" + botPrefix + "tag [list/create/delete] \"[trigger]\" \"[output]\"`");
    }
}
