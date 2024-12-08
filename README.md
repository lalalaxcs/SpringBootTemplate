### spring Boot 项目模板
# Conventional Commits 规范

**提交信息必须以一个类型作为前缀**，类型是一个名词，如 `feat`、`fix` 等，后面跟着 **可选的范围**（scope）、**可选的感叹号**（`!`），以及 **必须有的终止冒号和空格**。

- **`feat` 类型**：当提交是为应用程序或库添加新功能时，必须使用 `feat` 类型。
- **`fix` 类型**：当提交是修复应用程序中的 bug 时，必须使用 `fix` 类型。
- **范围（scope）**：范围是一个可选项，用来描述代码库中某个部分的名词，且必须用括号括起来。例如：`fix(parser)`。
- **描述**：描述必须紧跟在类型/范围前缀后，格式为 `:` 后接一个空格。描述应该简短总结这次提交的代码变更。例如：`fix: 解析数组时处理多空格字符串的错误`。
- **提交正文**（可选）：正文可以提供更详细的信息，进一步解释本次提交的背景。正文应该在描述之后的空行处开始。
    - 正文是自由格式的，可以包含多个由换行分隔的段落。

- **提交的尾部（Footer）**（可选）：尾部可以包含一个或多个信息，每个尾部应该在正文后面一个空行后开始。尾部的格式为：**一个标记词（token）**，后面跟着 `:` 或 `#`，然后是值。尾部的标记词必须用 `-` 代替空格字符。例如：`Acked-by`。
    - 其中，`BREAKING CHANGE` 是一个特殊的标记词（用于标识破坏性更改），在尾部出现时，格式为：`BREAKING CHANGE: ` 后接描述。
    - 如果破坏性更改是作为类型/范围的前缀标记的（例如 `feat(auth)!`），则尾部中的 `BREAKING CHANGE:` 可以省略，破坏性更改的描述应直接写在提交信息的描述部分。

## 其他要求：
- 破坏性更改必须在提交的类型/范围前缀中标明，或者在尾部提供。
- 如果提交信息中包含 `BREAKING CHANGE`，则该标记必须大写，并遵循特定格式。
- 提交的类型和标记词（如 `feat`、`fix` 等）**不区分大小写**，但 `BREAKING CHANGE` 必须大写。
- 尾部中的 `BREAKING-CHANGE` 必须等同于 `BREAKING CHANGE`。

#Dcoker 指令
启动docker服务 systemctl start docker 
查看docker状态 systemctl status docker 
redis 配置文件 /mydata/redis/conf/redis.conf
redis 密码 yourpassword

docker run --name  redis \
-p 6379:6379 \
-v /var/log/redis:/var/log/redis \
-v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf \
-v /docker-data/redis:/data \
-d redis redis-server /etc/redis/redis.conf --appendonly yes
